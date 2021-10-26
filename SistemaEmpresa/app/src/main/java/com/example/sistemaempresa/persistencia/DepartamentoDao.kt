package com.example.sistemaempresa.persistencia

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DepartamentoDao(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE Funcionario (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, ENDERECO TEXT, DATAADMISSAO TEXT, CARGO TEXT, " +
                    "SALARIO TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Cargo (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, DESCRICAO TEXT, FAIXASALARIAL TEXT, SUPERIOR TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Departamento (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, AREA TEXT, SERVICO TEXT, QUANTIDADEFUNCIONARIOS TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Empresa (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, DESCRICAO TEXT, ENDERECO TEXT, FINALIDADE TEXT," +
                    "QUANTIDADEANDARES TEXT)"
        )

        db.execSQL(
            "CREATE TABLE Inventario (ID INTEGER PRIMARY KEY " +
                    "AUTOINCREMENT,NOME TEXT, DESCRICAO TEXT, LOCALIDADE TEXT, NUMERODISPONIVEL TEXT)"
        )
    }


    /**
     * Função para realizar a deleção de uma tabela
     */
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_DEPARTAMENTO)
        onCreate(db)
    }

    /**
     * Função que realiza o cadastro dos dados
     */
    fun inserirDados(nome: String, area: String,
                     servico: String, qtdFuncionarios: String) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, area)
        contentValues.put(COL_4, servico)
        contentValues.put(COL_5, qtdFuncionarios)


        db.insert(TABLE_NAME_DEPARTAMENTO, null, contentValues)
    }

    /**
     * Função que realiza a atualização dos dados
     */
    fun alterarDados(id:String, nome: String, area: String,
                     servico: String, qtdFuncionarios: String): Boolean {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_1, id)
        contentValues.put(COL_2, nome)
        contentValues.put(COL_3, area)
        contentValues.put(COL_4, servico)
        contentValues.put(COL_5, qtdFuncionarios)


        db.update(TABLE_NAME_DEPARTAMENTO, contentValues, "ID = ?", arrayOf(id))
        return true
    }

    /**
     * Função que realiza a deleção pelo ID
     */
    fun deletarDados(id: String): Int {
        val db = this.writableDatabase
        return db.delete(TABLE_NAME_DEPARTAMENTO, "ID = ?", arrayOf(id))
    }

    /**
     * Selecionando todos os registros do banco de dados
     */
    val allData: Cursor
        get() {
            val db = this.writableDatabase
            val res = db.rawQuery("SELECT * FROM " + TABLE_NAME_DEPARTAMENTO, null)
            return res
        }

    /**
     * Criação de um companion object definindo o banco de dados e tabelas para o CRUD
     */
    companion object {
        val DATABASE_NAME = "SistemaGestao.db"
        val TABLE_NAME_DEPARTAMENTO = "Departamento"
        val COL_1 = "ID"
        val COL_2 = "NOME"
        val COL_3 = "AREA"
        val COL_4 = "SERVICO"
        val COL_5 = "QUANTIDADEFUNCIONARIOS"

    }
}
