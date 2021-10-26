package com.example.sistemaacademico.persistencia


import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteDatabase

/**
 * Let's start by creating our database CRUD helper class
 * based on the SQLiteHelper.
 */
class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NAME_ALUNO (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, EIXO TEXT, DURACAO TEXT, CLASSIFICACAO TEXT, " +
                    "MODALIDADE TEXT)"
        )

        db.execSQL(
            "CREATE TABLE $TABLE_NAME_CURSO (ID INTEGER PRIMARY KEY " +
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
     * Criação de um companion object definindo o banco de dados e tabelas para o CRUD
     */
    companion object {
        val DATABASE_NAME = "CrudCursoBD.db"
        val TABLE_NAME_ALUNO = "Aluno"
        val TABLE_NAME_CURSO = "Curso"

    }
}
//end