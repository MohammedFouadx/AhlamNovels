package sim.coder.ahlamnovels

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_book_page.*

class BookPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_page)



        // Shared Preferences

        val pref= getSharedPreferences("pref", Context.MODE_PRIVATE)
        val editor = pref.edit()
        var no =pref.getInt("book1",0)
        var noo =pref.getInt("book2",0)
        var nooo =pref.getInt("book3",0)
        var noooo =pref.getInt("book4",0)
        var nooooo =pref.getInt("book5",0)
        var book6= pref.getInt("book6",0)
        var book7= pref.getInt("book7",0)
        var book8= pref.getInt("book8",0)
        var book9= pref.getInt("book9",0)


        val getItem = intent.getStringExtra("pdfFileName")

        if (getItem == "نسيان") {
            PdfViewer.fromAsset("1.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book1",page)
                    editor.commit()
                }
                .defaultPage(no)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }


        if (getItem == "فوضى الحواس") {
            PdfViewer.fromAsset("2.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book2",page)
                    editor.commit()
                }
                .defaultPage(noo)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }


        if (getItem == "الأسود يليق بك") {
            PdfViewer.fromAsset("3.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book3",page)
                    editor.commit()
                }
                .defaultPage(nooo)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }

        if (getItem == "عابر سرير") {
            PdfViewer.fromAsset("4.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book4",page)
                    editor.commit()
                }
                .defaultPage(noooo)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }


        if (getItem == "على مرفأ الأيام") {
            PdfViewer.fromAsset("5.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book5",page)
                    editor.commit()
                }
                .defaultPage(nooooo)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }


        if (getItem == "عليك اللهفة") {
            PdfViewer.fromAsset("6.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book6",page)
                    editor.commit()
                }
                .defaultPage(book6)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }


        if (getItem == "قلوبهم معنا وقنابلهم علينا") {
            PdfViewer.fromAsset("7.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book7",page)
                    editor.commit()
                }
                .defaultPage(book7)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }



        if (getItem == "أكاذيب سمكة") {
            PdfViewer.fromAsset("8.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book8",page)
                    editor.commit()
                }
                .defaultPage(book8)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }


        if (getItem == "ذاكرة الجسد") {
            PdfViewer.fromAsset("9.pdf")
                .onPageChange { page, pageCount ->
                    editor.putInt("book9",page)
                    editor.commit()
                }
                .defaultPage(book9)
                .enableSwipe(true)
                .enableDoubletap(true)
                .load()
        }







    }

}