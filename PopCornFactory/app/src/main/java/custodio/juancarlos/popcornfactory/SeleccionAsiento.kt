package custodio.juancarlos.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import java.util.*
import kotlin.collections.ArrayList

class SeleccionAsiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.asiento_activity)
        val bundle= intent.extras
        var posMovie= -1
        var titulo=""
        if (bundle!=null){
            titulo= bundle.getString("titulo")!!
            tituloAsiento.setText(titulo)
            posMovie= bundle.getInt("id")
            disableButtons(bundle.getInt("tamanio"))
        }

        btnConfirmar.setOnClickListener {
            val cliente = Cliente (
                tipoPago = "Efectivo",
                nombre = "JC",
                asiento = seleccionAsiento(),
                pelicula = titulo
            )
            val intent: Intent = Intent(this,ReservacionActivity::class.java)
            intent.putExtra("nombre",cliente.nombre)
            intent.putExtra("asiento",cliente.asiento)
            intent.putExtra("pelicula",cliente.pelicula)
            this.startActivity(intent)
        }

        row1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row1.check(checkedId)
            }
        }
        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()
                row2.check(checkedId)
            }
        }
        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()
                row3.check(checkedId)
            }
        }
        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId>-1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()
                row4.check(checkedId)
            }
        }

    }

    private fun seleccionAsiento():Int{
        var seat=-1
        for (i in 0 until 20){
            var radioId:String="radio"+(i+1)
            var resID:Int=resources.getIdentifier(radioId,"id",packageName)
            var radio: RadioButton = findViewById(resID)
            if (radio.isChecked){
                seat=i+1
                return seat
            }
        }
        return seat
    }

    private fun disableButtons(seatAv:Int){
        var asientos:ArrayList<Int> = ArrayList<Int>()
        for (i in 0 until seatAv){
            asientos.add(1)
        }
        for (i in seatAv until 20){
            asientos.add(0)
        }
        Collections.shuffle(asientos)
        for (i in 0 until 20){
            if (asientos.get(i)==0){
                var radioId:String="radio"+(i+1)
                var resID:Int=resources.getIdentifier(radioId,"id",packageName)
                var radio: RadioButton = findViewById(resID)

                radio.isEnabled=false
            }
        }

    }
}