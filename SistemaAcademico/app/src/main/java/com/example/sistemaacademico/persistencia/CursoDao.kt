package com.example.sistemaacademico.persistencia

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class CursoDao(context: Context) :
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

        db.execSQL(
            "CREATE TABLE Campus (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, ENDERECO TEXT, CAPACIDADE TEXT, PONTOREFERENCIA TEXT, " +
                    "TURNO TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Turma (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, CURSO TEXT, CAMPUS TEXT, TURNO TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Disciplina (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, CURSO TEXT, TURNO TEXT, CARGAHORARIA TEXT, " +
                    "OBJETIVO TEXT)"
        )
    }


    /**
     * Função para realizar a deleção de uma tabela
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_CURSO)
        onCreate(db)
    }

    /**
     * Função que realiza o cadastro dos dados
     */
    fun inserirDados(nome: String, eixo: String, duracao: String, classificacao: String, modalidade: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, eixo)
        contentValues.put(COL_4, duracao)
        contentValues.put(COL_5, classificacao)
        contentValues.put(COL_6, modalidade)


        db.insert(TABLE_NAME_CURSO, null, contentValues)
    }

    /**
     * Função que realiza a atualização dos dados
     */
    fun alterarDados(id:String, nome: String, eixo: String,
                     duracao: String, classificacao: String, modalidade: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, eixo)
        contentValues.put(COL_4, duracao)
        contentValues.put(COL_5, classificacao)
        contentValues.put(COL_6, modalidade)


        db.update(TABLE_NAME_CURSO, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    /**
     * Função que realiza a deleção pelo ID
     */
    fun deletarDados(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME_CURSO, "ID = ?", arrayOf(id))
    }

    /**
     * Selecionando todos os registros do banco de dados
     */
    val allData: Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME_CURSO, null)
            return res
        }

    /**
     * Criação de um companion object definindo o banco de dados e tabelas para o CRUD
     */
    companion object {
        val DATABASE_NAME = "SistemaGestaoAcademica.db"
        val TABLE_NAME_CURSO = "Curso"
        val COL_1 = "ID"
        val COL_2 = "NOME"
        val COL_3 = "EIXO"
        val COL_4 = "DURACAO"
        val COL_5 = "CLASSIFICACAO"
        val COL_6 = "MODALIDADE"

    }
}
