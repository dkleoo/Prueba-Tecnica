package com.example.myappformulario.adapter


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myappformulario.R
import com.example.myappformulario.database.entities.CustomersEntity
import com.example.myappformulario.databinding.ItemlistcustomersBinding
import com.example.myappformulario.iu.Tab1.Tab1
import com.example.myappformulario.iu.Tab2.Tab2Edit

class ItemLIstCustomers : ListAdapter<CustomersEntity, ItemLIstCustomers.ItemLIstCustomersViewHolder>(DiffUtil()){

    class ItemLIstCustomersViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemlistcustomersBinding.bind(view)
        fun bind(item: CustomersEntity) {
            binding.document.text = item.cDocument.toString()
            binding.name.text = item.cName1
            binding.firtName.text = item.cLastName1
            binding.edit.setOnClickListener {
                val i = Intent(itemView.context, Tab2Edit::class.java)
                i.putExtra("id",item.id.toString())
                i.putExtra("cid",item.cid.toString())
                i.putExtra("document",item.cDocument.toString())
                i.putExtra("name1",item.cName1.toString())
                i.putExtra("name2",item.cNmae2.toString())
                i.putExtra("lastLame1",item.cLastName1.toString())
                i.putExtra("lastName2",item.cLastName2.toString())
                itemView.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemLIstCustomersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlistcustomers,parent,false)
        return ItemLIstCustomersViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemLIstCustomersViewHolder, position: Int) {
        val item:CustomersEntity = getItem(position)
        holder.bind(item)
    }

}

class DiffUtil : DiffUtil.ItemCallback<CustomersEntity>(){
    override fun areItemsTheSame(oldItem: CustomersEntity, newItem: CustomersEntity): Boolean {
        return oldItem.cDocument == newItem.cDocument
    }

    override fun areContentsTheSame(oldItem: CustomersEntity, newItem: CustomersEntity): Boolean {
        return oldItem == newItem
    }

}