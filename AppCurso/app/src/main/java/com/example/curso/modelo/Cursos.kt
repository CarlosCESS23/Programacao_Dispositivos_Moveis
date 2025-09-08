package com.example.curso.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


//DataClass -> É um tipo especial de classe em Kotlin, otimizada para conter os dados

data class Cursos(
    @StringRes val stringResources: Int, //Ela armazena os ID de String do recurso
    @DrawableRes val imageResources: Int, // Ela armazena os ID de Imagens do recurso
)

/*
Ou seja, essa classe, ela recebe os dados dos IDS no momento que criamos os objetos dos recursos (String e Images)
 */
