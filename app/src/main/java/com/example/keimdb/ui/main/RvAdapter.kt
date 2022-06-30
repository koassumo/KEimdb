package com.example.keimdb.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.keimdb.R
import com.example.keimdb.retrofit.api.ItemDTO

class RvAdapter : RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    var notes: List<ItemDTO> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    // 0. Определяем CLASS ViewHolder
    // т.е. это связь/установка соответствий с макетным файлом itemView (здесь - item_note.xml)
    // т.е. по принципу 'view from xml' = 'data from Note'
    // Самих данных пока нет, только шаблон.
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemDTO: ItemDTO) {
            itemView.findViewById<TextView>(R.id.tv_title).text = itemDTO.title
            itemView.findViewById<TextView>(R.id.tv_id).text = itemDTO.id
            itemView.findViewById<TextView>(R.id.tv_rank).text = itemDTO.rank
            itemView.findViewById<TextView>(R.id.tv_year).text = itemDTO.year
            itemView.findViewById<TextView>(R.id.tv_crew).text = itemDTO.crew
            itemView.findViewById<TextView>(R.id.tv_imDbRating).text = itemDTO.imDbRating
            itemView.findViewById<TextView>(R.id.tv_imDbRatingCount).text = itemDTO.imDbRatingCount
            itemView.findViewById<ImageView>(R.id.iv_avatar).load(itemDTO.image)
            // На вход конструктор (?) берет переданную ItemView и разбираем ее на составные части
            // при этом предварительно найти все вьюшки (как в java) здесь не требуется,
            // (но - это расход ресурсов, поэтому нужно как-то закэшировать)
        }
    }

    // Далее переопределяем ТРИ обязательных метода:

    // 1. Создаем каждый конкретный новый экземпляр viewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))

    // 2. Наполняем (связываем) viewHolder с данными (подставляем в шаблон конкретные значения Note)
    override fun onBindViewHolder(holder: RvAdapter.ViewHolder, position: Int) = holder.bind(
        notes[position]
    )
    // holder отделен от данных, т.к. это RecycleView, т.е. переиспользуемые созданные холдеры под другие данные

    // 3. Recycler должен знать сколько у него элементов. Данный метод не вызывается из кода
    override fun getItemCount(): Int = notes.size


    fun updateNote(newNotes: List<ItemDTO>) {
        this.notes = newNotes
//        notifyDataSetChanged()  - тут не нужно, т.к. определен в
    }

}


