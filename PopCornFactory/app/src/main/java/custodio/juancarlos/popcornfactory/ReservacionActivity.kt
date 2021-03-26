package custodio.juancarlos.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ReservacionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reservacion)
        val bundle= intent.extras
        if (bundle!=null){
            asientoReservacion.setText("Tu asiento es: "+bundle.getInt("asiento"))
            tituloPeliculaReservacion.setText("Tu pelicula es: "+bundle.getString("pelicula"))
            nombreReservacion.setText(bundle.getString("nombre"))
        }
    }
}