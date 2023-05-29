package BekhrUzBEK.valyutakursi

import BekhrUzBEK.valyutakursi.databinding.FragmentConverterBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment

class ConverterFragment : Fragment() {
    private lateinit var binding: FragmentConverterBinding
    private lateinit var myValyuta: MyValyuta
    private lateinit var valyutaList: ArrayList<MyValyuta>
    private lateinit var countryList:ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConverterBinding.inflate(layoutInflater)

        countryName()

        binding.spinner1.adapter=ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, countryName())
        binding.spinner2.adapter=ArrayAdapter<String>(binding.root.context, android.R.layout.simple_list_item_1, countryName())

        binding.btnOk.setOnClickListener {
            val country1 = valyutaList[binding.spinner1.selectedItemPosition]
            val country2 = valyutaList[binding.spinner2.selectedItemPosition]
            val country = convert(country2, country1)
            val summa = binding.edt.text.toString().toFloat()
            val result = country*summa
            binding.txtView.text = result.toString()
        }

        return binding.root
    }

    private fun countryName():ArrayList<String> {
        countryList= ArrayList()
        valyutaList= ArrayList()
        valyutaList.addAll(MyObject.valyutaList)
        valyutaList.forEach {
            countryList.add(it.CcyNm_UZ.toString())
        }
        return countryList
    }

    fun convert(valyuta: MyValyuta, valyuta2: MyValyuta):Float{
        return valyuta2.Rate!!.toFloat()/valyuta.Rate!!.toFloat()
    }
}