package com.example.curso.dados


import androidx.compose.ui.res.painterResource
import com.example.curso.R
import com.example.curso.modelo.Cursos

class FontesDados() {

    fun carregarCursos(): List<Cursos> {
        return listOf<Cursos>(
            Cursos(R.string.curso1, R.drawable.cienciacomputacao),
            Cursos(R.string.curso2,R.drawable.engenhariamecanica),
            Cursos(R.string.curso3,R.drawable.engenhariacivil),
            Cursos(R.string.curso4,R.drawable.cienciabiologica),
            Cursos(R.string.curso5,R.drawable.licenciaturaemmatematica),
            Cursos(R.string.curso6,R.drawable.licenciaturaemf_sica),
            Cursos(R.string.curso7,R.drawable.licenciaturaemquimica),
            Cursos(R.string.curso8,R.drawable.tecnologiaemproducaopub),
            Cursos(R.string.curso9,R.drawable.tecnicoquimica),
            Cursos(R.string.curso10,R.drawable.tecnologiaemalimento),
            Cursos(R.string.curso11,R.drawable.analise),
            Cursos(R.string.curso12,R.drawable.tecnicoseguranca),
            Cursos(R.string.curso13,R.drawable.tecnicoemedificacao),
            Cursos(R.string.curso14,R.drawable.tecnicoquimica),
            Cursos(R.string.curso15,R.drawable.tecnicoemeletrot_cnica),
            Cursos(R.string.curso16,R.drawable.tecnicoemmecatronica)

        )
    }
}