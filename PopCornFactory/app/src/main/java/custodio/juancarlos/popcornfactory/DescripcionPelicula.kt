package custodio.juancarlos.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DescripcionPelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.descripcion_activity)

        val bundle=intent.extras
        var numAsientos=0
        var id=-1
        var titulo="texto"

        if(bundle!=null){
            titulo= bundle.getString("titulo")!!
            numAsientos=bundle.getInt("numeroAsientos")
            imgPeliculaDescripcion.setImageResource(bundle.getInt("header"))
            tituloPeliculaDescripcion.setText(bundle.getString("titulo"))
            descripcionPelicula.setText(bundle.getString("descripcion"))
            asientosRestantes.setText("$numAsientos asientos disponibles ")
            id=bundle.getInt("pos")
        }

        if(numAsientos==0){
            btnComprar.isEnabled=false
        }else{
            btnComprar.isEnabled=true
            btnComprar.setOnClickListener {
                val intent: Intent = Intent(this,SeatSelection::class.java)
                intent.putExtra("id", id)
                intent.putExtra("tamanio",numAsientos)
                intent.putExtra("titulo",titulo)
                this.startActivity(intent)
            }
        }

    }
}