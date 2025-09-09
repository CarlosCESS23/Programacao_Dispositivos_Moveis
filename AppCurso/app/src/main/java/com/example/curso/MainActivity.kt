package com.example.curso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.curso.dados.FontesDados
import com.example.curso.modelo.Cursos
import com.example.curso.ui.theme.CursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoTheme {
               Surface(
                   modifier = Modifier.fillMaxSize(),
                   color = MaterialTheme.colorScheme.background
               ){
                   CursosApp()
                }
            }
        }
    }
}


@Composable
fun CursosApp(){
    ListasCurso(FontesDados().carregarCursos1(),FontesDados().carregarCursos2(),
        )
}


@Composable // Anotação que informa ao compilador que isso é uma parte UI
fun ListasCurso(
    ListasCursos1: List<Cursos>,
    ListasCursos2: List<Cursos>,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        //LazyColumn -> Dá uma possibilidade de rolagem na tela, lista rolável
        LazyColumn(modifier = modifier.weight(1f)) {

            items(ListasCursos1) { cursos1 ->
                CarregarCursos(
                    cursos = cursos1,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        LazyColumn(modifier = modifier.weight(1f)) { // Utilização do weight -> Ocupa uma porção do espaço disponível (dando o peso de 1f para 2 itens, eles se dividirão igualmente)
            items(ListasCursos2) { cursos2 ->
                CarregarCursos(
                    cursos = cursos2,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

/*
+--------------------------------+
| Coluna 1 (Lista 1) | Coluna 2 (Lista 2) |
|                            |                    |
| [ Item do Curso 1 ]    | [ Item do Curso A ]    |
| [ Item do Curso 2 ]    | [ Item do Curso B ]    |
| [ Item do Curso 3 ]    | [ Item do Curso C ]    |
|        ...             |         ...            |
|       (rolável)        |       (rolável)        |
+--------------------------------+



 */


@Composable
fun CarregarCursos(cursos: Cursos, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column{
            Image(
                painter = painterResource(cursos.imageResources),
                contentDescription = stringResource(cursos.stringResources),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(cursos.stringResources),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
        }
        }
    }


