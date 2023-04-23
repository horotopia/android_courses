package com.example.myapplication

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.myapplication.Product
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProductDetailFragment: Fragment(){

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext()).inflate(
            R.layout.fragment_detail,
            container, false,
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         /*val thisProduct = Product(
            thumbnail = product.thumbnail,
            name = FicheFragmentArgs.fromBundle(args).product.name,
            brand = FicheFragmentArgs.fromBundle(args).product.brand,
            nutriScore = FicheFragmentArgs.fromBundle(args).product.nutriScore,
            barcode = FicheFragmentArgs.fromBundle(args).product.barcode,
            quantity = FicheFragmentArgs.fromBundle(args).product.quantity,
            countries = FicheFragmentArgs.fromBundle(args).product.countries,
            ingredients = FicheFragmentArgs.fromBundle(args).product.ingredients,
            allergens = FicheFragmentArgs.fromBundle(args).product.allergens,
            additives = FicheFragmentArgs.fromBundle(args).product.additives,
        )

        Glide.with(this).load(product.thumbnail).into(view.findViewById(R.id.image))
        view.findViewById<TextView>(R.id.name).setText(Product.name)
        view.findViewById<TextView>(R.id.brand).setText(product.brand)
        view.findViewById<ImageView>(R.id.nutriScore).setImageResource(resources.getIdentifier(
            "nutriScore_${product.nutriScore.label.lowercase()}",
            "mipmap",
            "com.example.myapplication",
        ))
        view.findViewById<TextView>(R.id.barcode).applyBoldText("Code barres", product.barcode)
        view.findViewById<TextView>(R.id.quantity).applyBoldText("Quantité",product.quantity)
        view.findViewById<TextView>(R.id.sale).applyBoldText(
            "Vendu en",
            product.countries.joinToString ( ", " ))
        view.findViewById<TextView>(R.id.ingredient).applyBoldText(
            "Ingrédients",
            product.ingredients.joinToString ( ", " ))
        view.findViewById<TextView>(R.id.substance).applyBoldText(
            "Substances Allergènes",
            product.allergens.joinToString ( ", " ))
        view.findViewById<TextView>(R.id.addictif).applyBoldText(
            "additives",
            product.additives.joinToString ( ", " ))

    }

    fun TextView.applyBoldText(prefix: String, value: String) {
        val text = "$prefix : $value"
        val builder = SpannableStringBuilder(text)
        builder.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(":") + 1, 0)
        setText(builder)
    }*/
}