package custodio.juancarlos.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MenuActivity : AppCompatActivity() {
    var peliculas = ArrayList<Pelicula>()
    var adapter: MovieAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_activity)
        agregarPeliculas()
        adapter = MovieAdapter(this, peliculas)
        gridPeliculas.adapter = adapter
    }

    fun agregarPeliculas(){
        peliculas.add(Pelicula("Big Hero 6", R.drawable.bighero6, R.drawable.headerbighero6, "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Leap year", R.drawable.leapyear, R.drawable.leapyearheader,"A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback  when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency&#39;s finest men only going by the name &quot;K&quot; (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the &quot;Bug&quot; race. He takes the body of a farmer (Vincent D&#39;Onofrio) and heads to New York.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the &#39;secret life of toys&#39; when people are not around. When Buzz Lightyear, a space-ranger, takes Woody&#39;s place as Andy&#39;s favorite toy, Woody doesn&#39;t like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home.", arrayListOf<Cliente>()))
        peliculas.add(Pelicula("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb&#39;s rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. ", arrayListOf<Cliente>()))
    }

    class MovieAdapter: BaseAdapter{
        var peliculas = ArrayList<Pelicula>()
        var contexto: Context?=null

        constructor(contexto: Context, peliculas:ArrayList<Pelicula>){
            this.contexto = contexto
            this.peliculas = peliculas
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
            var pelicula = peliculas[position]
            var inflador = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var view = inflador.inflate(R.layout.pelicula, null)
            view.imgPelicula..setImageResource(pelicula.img)
            view.tituloPelicula.setText(pelicula.titulo)
            var numeroAsientos = -1
            view.imgPelicula.setOnClickListener {
                numeroAsientos=getAsientos()
                var intent = Intent(contexto, DescripcionPelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("img", pelicula.img)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("descripcion", pelicula.descripcion)
                intent.putExtra("numeroAsientos",(20-numeroAsientos))
                intent.putExtra("pos",position)
                contexto!!.startActivity(intent)
            }
            return view
        }

        fun getAsientos(): Int{
            val random= java.util.Random()
            return random.nextInt(21)
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return peliculas.size
        }

    }
}