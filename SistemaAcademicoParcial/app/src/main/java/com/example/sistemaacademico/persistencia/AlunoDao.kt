package com.example.sistemaacademico.persistencia

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class AlunoDao(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE Aluno (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, ENDERECO TEXT, CURSO TEXT, TURMA TEXT, " +
                    "SEMESTRE TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Curso (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, EIXO TEXT, DURACAO TEXT, CLASSIFICACAO TEXT, " +
                    "MODALIDADE TEXT)"
        )
    }

    /**
     * Função para realizar a deleção de uma tabela
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_ALUNO)
        onCreate(db)
    }

    /**
     * Função que realiza o cadastro dos dados
     */
    fun inserirDados(nome: String, endereco: String,
                     curso: String, turma: String, semestre: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, endereco)
        contentValues.put(COL_4, curso)
        contentValues.put(COL_5, turma)
        contentValues.put(COL_6, semestre)


        db.insert(TABLE_NAME_ALUNO, null, contentValues)
    }

    /**
     * Função que realiza a atualização dos dados
     */
    fun alterarDados(id:String, nome: String, endereco: String,
                     curso: String, turma: String, semestre: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, endereco)
        contentValues.put(COL_4, curso)
        contentValues.put(COL_5, turma)
        contentValues.put(COL_6, semestre)


        db.update(TABLE_NAME_ALUNO, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    /**
     * Função que realiza a deleção pelo ID
     */
    fun deletarDados(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME_ALUNO, "ID = ?", arrayOf(id))
    }

    /**
     * Selecionando todos os registros do banco de dados
     */
    val allData: Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME_ALUNO, null)
            return res
        }

    /**
     * Criação de um companion object definindo o banco de dados e tabelas para o CRUD
     */
    companion object {
        val DATABASE_NAME = "CrudSistemasBCDE.db"
        val TABLE_NAME_ALUNO = "Aluno"
        val COL_1 = "ID"
        val COL_2 = "NOME"
        val COL_3 = "ENDERECO"
        val COL_4 = "CURSO"
        val COL_5 = "TURMA"
        val COL_6 = "SEMESTRE"

    }
}
