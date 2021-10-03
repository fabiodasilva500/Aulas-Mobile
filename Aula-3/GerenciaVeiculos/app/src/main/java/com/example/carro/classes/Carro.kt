package com.example.carro.classes

class Carro {
    private var modelo: String = ""
    private var ano: Int = 2021
    private var velocidade: Double = 0.0

    public fun getModelo(): String {
        return this.modelo
    }

    public fun setModelo(modelo: String) {
        this.modelo = modelo
    }

    public fun getAno(): Int {
        return this.ano
    }

    public fun setAno(ano: Int) {
        this.ano = ano
    }

    public fun getVelocidade(): Double {
        return this.velocidade
    }

    public fun setVelocidade(velocidade: Double) {
        this.velocidade = velocidade
    }

}
