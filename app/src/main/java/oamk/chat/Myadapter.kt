package oamk.chat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView


class Myadapter(private val MyDataset: ArrayList<Message>): RecyclerView.Adapter<Myadapter.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val message : TextView = itemView.findViewById(R.id.message)
        val author: TextView = itemView.findViewById(R.id.author)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val myView= LayoutInflater.from(parent.context)
            .inflate(R.layout.message_row,parent,false)
        return MyViewHolder(myView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.message.text= MyDataset.get(position).message
        holder.author.text=
                "by" + " " + MyDataset.get(position).author +" "+ "on" +" "+ MyDataset.get(position).time



    }

    override fun getItemCount() = MyDataset.size

}