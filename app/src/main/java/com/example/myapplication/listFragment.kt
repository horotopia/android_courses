package com.example.myapplication

import android.nfc.tech.NfcBarcode
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListFragment : Fragment() {

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_list,
            container, false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product1 = Product(
            thumbnail = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            name = "Petits pois et carottes",
            brand = "Cassegrain",
            nutriScore = nutriScore.A,
            barcode = "5000159484695",
            quantity = "400 g (280 g net égouté)",
            countries = listOf("France","Japon","SuisseLOL"),
            ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8%", "(Salade", "oignon", "grelot)", "sucre", "sel", "arôme naturel"),
            allergens = listOf("Aucune"),
            additives = listOf("Aucun")
        )
        val product2 = Product(
            thumbnail = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            name = "Petits pois et carottes",
            brand = "Cassegrain",
            nutriScore = nutriScore.A,
            barcode = "5000159484695",
            quantity = "400 g (280 g net égouté)",
            countries = listOf("France","Japon","SuisseLOL"),
            ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8%", "(Salade", "oignon", "grelot)", "sucre", "sel", "arôme naturel"),
            allergens = listOf("Aucune"),
            additives = listOf("Aucun")
        )
        val product3 = Product(
            thumbnail = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            name = "Petits pois et carottes",
            brand = "Cassegrain",
            nutriScore = nutriScore.A,
            barcode = "5000159484695",
            quantity = "400 g (280 g net égouté)",
            countries = listOf("France","Japon","SuisseLOL"),
            ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8%", "(Salade", "oignon", "grelot)", "sucre", "sel", "arôme naturel"),
            allergens = listOf("Aucune"),
            additives = listOf("Aucun")
        )
        val product4 = Product(
            thumbnail = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            name = "Petits pois et carottes",
            brand = "Cassegrain",
            nutriScore = nutriScore.A,
            barcode = "5000159484695",
            quantity = "400 g (280 g net égouté)",
            countries = listOf("France","Japon","SuisseLOL"),
            ingredients = listOf("Petits pois 66%", "eau", "garniture 2,8%", "(Salade", "oignon", "grelot)", "sucre", "sel", "arôme naturel"),
            allergens = listOf("Aucune"),
            additives = listOf("Aucun")
        )
        val product5 = Product(
            thumbnail = "https://images.openfoodfacts.org/images/products/327/408/000/5003/front_en.797.400.jpg",
            name = "Eau de source",
            brand = "Cristaline",
            nutriScore = nutriScore.A,
            barcode = "5000159484695",
            quantity = "1,5 L",
            countries = listOf("Belgium", "Côte d'Ivoire", "France", "Germany", "Guadeloupe", "Italy", "Luxembourg", "Mali", "Martinique", "Switzerland", "United Kingdom", "Allemagne", "Belgique", "Nouvelle-Calédonie", "Royaume-Uni", "Suisse", "États-Unis"),
            ingredients = listOf("eau"),
            allergens = listOf("Aucune"),
            additives = listOf("Aucun")
        )

        val cardsList = listOf(product1, product2, product3, product4, product5)
        view.findViewById<RecyclerView>(R.id.list).apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ListAdapter(cardsList, object : OnProductClickListener {
                override fun onProductClicked(product: Product) {
                    findNavController().navigate(
                        ListFragmentDirections.actionListFragmentToFicheFragment(
                            barcode = product.barcode
                        )
                    )
                }
            })
        }
    }
}
class ListAdapter(private val listOfPositions: List<Product>,
                  val listener: OnProductClickListener,
) : RecyclerView.Adapter<PositionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PositionViewHolder {
        return PositionViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false),
            listener,
        )
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        holder.updateCell(listOfPositions[position])
    }

    override fun getItemCount(): Int {
        return listOfPositions.size
    }

}

class PositionViewHolder(v: View, val listener: OnProductClickListener) : RecyclerView.ViewHolder(v) {

    private val thumbnail : ImageView =v.findViewById(R.id.image)
    private val name : TextView = v.findViewById(R.id.name)
    private val brand : TextView = v.findViewById(R.id.brand)
    private val nutriInfo : TextView = v.findViewById(R.id.nutriInfo)

    fun updateCell(product: Product) {
        itemView.setOnClickListener {
            listener.onProductClicked(product)
        }

        Glide.with(itemView.context).load(product.thumbnail).into(thumbnail)
        name.text = product.name
        brand.text = product.brand
        nutriInfo.text ="234 kCal/part"
    }

}

interface OnProductClickListener {
    fun onProductClicked(product: Product)
}