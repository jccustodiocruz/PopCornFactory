package custodio.juancarlos.popcornfactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detalle_pelicula)

        val bundle= intent.extras

        if(bundle!=null){
            imgPeliculaDetalle.setImageResource(bundle.getInt("header"))
            tituloPeliculaDetalle.setText(bundle.getString("titulo"))
            descripcion.setText(bundle.getString("descripcion"))
        }
    }
}