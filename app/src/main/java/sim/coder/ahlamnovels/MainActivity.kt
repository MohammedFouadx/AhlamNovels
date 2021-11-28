package sim.coder.ahlamnovels

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , Adapter.OnItemLisetner {




    private lateinit var mInterstitialAd: InterstitialAd


    override fun OnClick(item: BooksData, position: Int) {
        val start = Intent(applicationContext, BookPage::class.java)
        start.putExtra("pdfFileName", item.Title)
        startActivity(start)    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.customView
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //Banner ads

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)



        //Interstitial ads ---------------------------- ------------------------------------

        MobileAds.initialize(this) {}
        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-5329195808649014/1362574283"
        mInterstitialAd.loadAd(
            AdRequest.Builder()
                .build())

        mInterstitialAd.adListener= object : AdListener(){

            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }







// -----------------------------------------------------------------------------------------------


//---------Rating Button --------------------------


//        rating.setOnClickListener {
//            val rate= Intent(Intent.ACTION_VIEW)
//            rate.data= Uri.parse("https://play.google.com/store/apps/details?id=sim.coder.ahlamnovels")
//            startActivity(rate)
//        }


//---------Rating Button --------------------------

        // RecyclerView List -------------------------------------------------------------------------

        val gridLayout= GridLayoutManager(applicationContext,3,LinearLayoutManager.VERTICAL,false)

        var recyclerView: RecyclerView =findViewById(R.id.recyclePdf)
        recyclerView.layoutManager= gridLayout
        recyclerView.setHasFixedSize(true)

        var book=ArrayList<BooksData>()

        book.add(BooksData("نسيان",R.drawable.m1))
        book.add(BooksData("فوضى الحواس",R.drawable.m2))
        book.add(BooksData("الأسود يليق بك",R.drawable.m3))
        book.add(BooksData("عابر سرير",R.drawable.m4))
        book.add(BooksData("على مرفأ الأيام",R.drawable.m5))
        book.add(BooksData("عليك اللهفة",R.drawable.m6))
        book.add(BooksData("قلوبهم معنا وقنابلهم علينا",R.drawable.m7))
        book.add(BooksData("أكاذيب سمكة",R.drawable.m8))
        book.add(BooksData("ذاكرة الجسد",R.drawable.m9))


        recyclerView.adapter=Adapter(book,this)





    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu, menu)
        return true

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {


        when(item.itemId){
            R.id.star -> {
                val rate= Intent(Intent.ACTION_VIEW)
                rate.data= Uri.parse("https://play.google.com/store/apps/details?id=sim.coder.ahlamnovels")
                startActivity(rate)
                
            }
        }

        return super.onOptionsItemSelected(item)
    }


    // Alert Dialog/////////////////////////////////////////////////////////////////////////////////////

    override fun onBackPressed() {

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("تذكر!!")
        dialog.setMessage("أن القراءة هي المخدرات المجانية في هذا العصر...")

        dialog.setPositiveButton("مشاركة التطبيق ",{ dialogInterface: DialogInterface, i: Int ->
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=sim.coder.ahlamnovels")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        })

        dialog.setNegativeButton("خروج",{ dialogInterface: DialogInterface, i: Int ->
            finish()

        })


        dialog.show()

    }



}
