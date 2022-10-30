package com.faryz.canteenmealapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.faryz.canteenmealapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val menuList = mutableListOf<ListMenu>()
        val menuDrinkList = mutableListOf<ListMenu>()

        menuList.add(ListMenu("https://i.ytimg.com/vi/pOJEmDBgtSk/maxresdefault.jpg", "Mee Goreng Mamak"))
        menuList.add(ListMenu("https://rasamalaysia.com/wp-content/uploads/2007/01/nasi_lemak-1.jpg", "Nasi Lemak"))
        menuList.add(ListMenu("https://resepichenom.com/media/92631CD8-98DF-48A3-A396-46020FD88812.jpeg", "Nasi Goreng Cina"))
        menuList.add(ListMenu("https://img-global.cpcdn.com/recipes/6bb6e78531066977/400x400cq70/photo.jpg", "Nasi Goreng Kampung"))
        menuList.add(ListMenu("https://i0.wp.com/resepibonda.my/wp-content/uploads/2015/03/nasi-goreng-pattaya.jpg?ssl=1", "Nasi Goreng Pattaya"))
        menuList.add(ListMenu("https://resepichenom.com/media/9b3cbb4aad805578e184e65d03af4ec56db220dc.jpeg", "Kuey Teow Goreng"))
        menuList.add(ListMenu("https://christieathome.com/wp-content/uploads/2020/12/Indonesian-Bihun-Goreng-4-scaled.jpg", "Bihun Goreng"))
        menuDrinkList.add(ListMenu("https://www.luluhypermarket.com/medias/40694-0001.jpg-1200Wx1200H?context=bWFzdGVyfGltYWdlc3w5MTM3MDB8aW1hZ2UvanBlZ3xoNDYvaDUwLzExOTYwMTY3NzI3MTM0LzQwNjk0LTAwMDEuanBnXzEyMDBXeDEyMDBIfDlhNTYyMWQwZGY5YzA1NzE3NWVjNjBkMWY5YmExZmUyM2FjODI5MTU5OGQ5MDI2YzQxZGUxMzk0ZDA4ZWFjNDY", "Jus Oren"))
        menuDrinkList.add(ListMenu("https://www.rasa.my/wp-content/uploads/2020/02/tembikai1.jpg", "Jus Tembikai"))
        menuDrinkList.add(ListMenu("https://upload.wikimedia.org/wikipedia/commons/5/5c/Becher_Kakao_mit_Sahneh%C3%A4ubchen.JPG", "Hot Coklat"))
        menuDrinkList.add(ListMenu("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIsgFpiNI5It7ZmWfyCRParaSvYSNoVIqYIw&usqp=CAU", "Sirap Bandung Cincau"))
        menuDrinkList.add(ListMenu("https://upload.wikimedia.org/wikipedia/commons/2/26/Teh_Tarik.jpg", "Teh Tarik"))
        menuDrinkList.add(ListMenu("https://sedapnya.com/wp-content/uploads/2021/05/teh-o-ais-1.jpg", "Teh O Ais"))

        binding.menuRecyclerView.apply {
            layoutManager = GridLayoutManager(this@HomeFragment.context, 2)
            adapter = MenuListAdapter(menuList)
        }

        binding.menuDrinkRecyclerView.apply {
            layoutManager = GridLayoutManager(this@HomeFragment.context, 2)
            adapter = MenuListAdapter(menuDrinkList)
        }

        return binding.root
    }
}

data class ListMenu (
    val imgUrl: String,
    val title: String
)
