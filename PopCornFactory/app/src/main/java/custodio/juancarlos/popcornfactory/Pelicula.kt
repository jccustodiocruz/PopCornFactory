package custodio.juancarlos.popcornfactory

data class Pelicula (var titulo:String,
                  var img:Int,
                  var header: Int,
                  var descripcion: String,
                  var asientos: ArrayList<Cliente>)