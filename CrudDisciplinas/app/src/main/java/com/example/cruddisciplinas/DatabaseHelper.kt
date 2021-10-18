package com.example.cruddisciplinas

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

/**
 * Let's start by creating our database CRUD helper class
 * based on the SQLiteHelper.
 */
class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    /**
     * Our onCreate() method.
     * Called when the database is created for the first time. This is
     * where the creation of tables and the initial population of the tables
     * should happen.
     */
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE $TABLE_NAME (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, CURSO TEXT, TURNO TEXT, CARGAHORARIA TEXT, " +
                    "OBJETIVO TEXT)"
        )
    }

    /**
     * Função para realizar a deleção de uma tabela
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    /**
     * Função que realiza o cadastro dos dados
     */
    fun inserirDados(nome: String, curso: String,
        turno: String, cargaHoraria: String, objetivo: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, curso)
        contentValues.put(COL_4, turno)
        contentValues.put(COL_5, cargaHoraria)
        contentValues.put(COL_6, objetivo)


        db.insert(TABLE_NAME, null, contentValues)
    }

    /**
     * Função que realiza a atualização dos dados
     */
    fun alterarDados(id:String, nome: String, curso: String,
                   turno: String, cargaHoraria: String, objetivo: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, curso)
        contentValues.put(COL_4, turno)
        contentValues.put(COL_5, cargaHoraria)
        contentValues.put(COL_6, objetivo)


        db.update(TABLE_NAME, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    /**
     * Função que realiza a deleção pelo ID
     */
    fun deletarDados(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME, "ID = ?", arrayOf(id))
    }

    /**
     * Selecionando todos os registros do banco de dados
     */
    val allData: Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null)
            return res
        }

    /**
     * Criação de um companion object definindo o banco de dados e tabelas para o CRUD
     */
    companion object {
        val DATABASE_NAME = "CrudDisciplinasBD.db"
        val TABLE_NAME = "crud_tabela"
        val COL_1 = "ID"
        val COL_2 = "NOME"
        val COL_3 = "CURSO"
        val COL_4 = "TURNO"
        val COL_5 = "CARGAHORARIA"
        val COL_6 = "OBJETIVO"

    }
}
//end