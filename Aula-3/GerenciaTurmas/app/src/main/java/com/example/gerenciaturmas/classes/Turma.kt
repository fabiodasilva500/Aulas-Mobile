package com.example.gerenciaturmas.classes

class Turma() {
    private var id: Int = 0
    private var nome: String = ""
    private var qtdAlunos: Int = 0

    public fun getId(): Int {
        return this.id
    }

    public fun setId(id: Int) {
        this.id = id
    }


    public fun getNome(): String {
        return this.nome
    }

    public fun setNome(nome: String) {
        this.nome = nome
    }

    public fun getQtdAlunos(): Int {
        return this.qtdAlunos
    }

    public fun setQtdAlunos(qtdAlunos: Int) {
        this.qtdAlunos = qtdAlunos
    }


}