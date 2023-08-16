//---------------------------------------------------------------------------

#include <vcl.h>
#pragma hdrstop

#include "Unit1.h"
//---------------------------------------------------------------------------
#pragma package(smart_init)
#pragma resource "*.dfm"
TForm1 *Form1;
//---------------------------------------------------------------------------
__fastcall TForm1::TForm1(TComponent* Owner)
        : TForm(Owner)
{
}
//=============================================
void Ajouter(String sq)
{
        Form1->Query1->Close();
        Form1->Query1->SQL->Clear();
        Form1->Query1->SQL->Add(sq);
        Form1->Query1->ExecSQL();
}
//===============================================
//---------------------------------------------------------------------------

void __fastcall TForm1::Button1Click(TObject *Sender)
{
      String nom=Form1->Edit1->Text;
      String prenom=Form1->Edit2->Text;
      String age=Form1->Edit3->Text;
      String rq="insert into personne(nom,prenom,age) values('"+nom+"','"+prenom+"',"+age+")";
      Ajouter(rq);
      ShowMessage("vita");
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ComboBox1DropDown(TObject *Sender)
{
        Form1->ComboBox1->Items->Clear();
        String req="select numero from personne";
        Ajouter(req);
        Form1->Query1->Active=true;
        while(Form1->Query1->Eof==false)
        {
            String n=Form1->Query1->FieldByName("numero")->AsString;
            Form1->ComboBox1->Items->Add(n);
            Form1->Query1->Next();    
        }
}
//---------------------------------------------------------------------------
void __fastcall TForm1::ComboBox1Change(TObject *Sender)
{
     String numero=Form1->ComboBox1->Text;
     String rq="select nom,prenom,age from personne where numero="+numero;
     Ajouter(rq);
     Form1->Query1->Active=true;
     while(Form1->Query1->Eof==false)
     {
        Form1->Edit4->Text=Form1->Query1->FieldByName("nom")->AsString;
        Form1->Edit5->Text=Form1->Query1->FieldByName("prenom")->AsString;
        Form1->Edit6->Text=Form1->Query1->FieldByName("age")->AsString;
        Form1->Query1->Next();
     }
}
//---------------------------------------------------------------------------

void __fastcall TForm1::Button2Click(TObject *Sender)
{
        String numero=Form1->ComboBox1->Text;
        String rq="delete from personne where numero="+numero;
        Ajouter(rq);
        ShowMessage("Vita");
        Form1->Edit4->Text="";
        Form1->Edit5->Text="";
        Form1->Edit6->Text="";
}
//---------------------------------------------------------------------------

void __fastcall TForm1::Button3Click(TObject *Sender)
{
    String numero=Form1->ComboBox1->Text;
    String nom=Form1->Edit4->Text;
    String prenom=Form1->Edit5->Text;
    String age=Form1->Edit6->Text;
    String rq="update personne set nom='"+nom+"',prenom='"+prenom+"',age="+age+" where numero="+numero;
    Ajouter(rq);
    ShowMessage("vita");
}
//---------------------------------------------------------------------------

