package com.example.myapplication.ui.conteudo

import android.util.Log
import com.example.myapplication.Service
import com.example.myapplication.ui.model.Filme
import com.example.myapplication.ui.model.FilmeResponse
import com.example.myapplication.ui.retrofit.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/*O presenter recebe uma view de parametro
 para poder utilizar os metodos dela
 e extende a interface Presenter do contrato
  para poder implementar seus metodos*/

class PopularesPresenter(val view:PopularesContrato.View) : PopularesContrato.Presenter {

    /* A funcao pegarLista() faz a chamada de serviço
     getPopulares que esta contida na Interface de Serviços (Service)
     e faz a chamada Assincrona com .enqueue que implementa os metodos
      OnResponse e OnFailure */

    override fun pegarLista() {
            val call = RetrofitInitializer().service().getPopulares(Service.api_key)
            call.enqueue(object : Callback<FilmeResponse> {

                /* Onfailure recebe a chamada de servico como parametro e é executada caso o servico retorne erro */
                override fun onFailure(call: Call<FilmeResponse>, t: Throwable) {
                    Log.e("deu ruim", t?.message)
                }


                /* OnResponse recebe uma chamada de servico como parametro e sua resposta
                * caso seja executado (retorno correto do servico), atribui o Objeto recebido a uma lista
                * depois é chamada a funcao da view setupRecycler para setar o RecyclerView com a lista de filmes recebida */
                override fun onResponse(
                    call: Call<FilmeResponse>,
                    response: Response<FilmeResponse>
                ) {
                    val objetoRecebido: FilmeResponse = response.body()!!
                    val lista: List<Filme> = objetoRecebido.results
                    view.setupRecycler(lista)
                }
            })
    }
}

