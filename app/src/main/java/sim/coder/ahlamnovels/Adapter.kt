package sim.coder.ahlamnovels


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class Adapter(val bookList:ArrayList<BooksData>,
              var clickListener: MainActivity):RecyclerView.Adapter<Adapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var view=LayoutInflater.from(parent.context).inflate(R.layout.list_design,parent,false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        var book:BooksData=bookList[position]
//        holder.title.text=book.Title



        holder.ini(bookList.get(position),clickListener)
        holder.bindView(bookList[position])




    }

    class ViewHolder (item:View) :RecyclerView.ViewHolder(item){
        val title:TextView=item.findViewById(R.id.NovelTitle)
        val img:ImageView=item.findViewById<ImageView>(R.id.bookImage)

        fun bindView(image: BooksData){

            img.setImageResource(image.imageSrc)

        }



        fun ini(item: BooksData, action: OnItemLisetner){

            title.text=item.Title


            itemView.setOnClickListener {
                action.OnClick(item ,adapterPosition)
            }
        }

    }

    interface OnItemLisetner{
        fun OnClick(item: BooksData,position: Int)
    }




}