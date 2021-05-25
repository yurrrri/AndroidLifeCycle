package ddwucom.mobile.lifecycle_app

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val cat = intent.getStringExtra("category")

        var pref : SharedPreferences = getSharedPreferences("SaveState", 0)
        username.setText(pref.getString("username", "닉네임"))
        category.setText(cat)

//       kotlin에서는 문자열 비교를 ==로 함
//        java -> equals
        if (cat=="맛집")
            layoutInflater.inflate(R.layout.restaurant_list, list, true)
        else
            layoutInflater.inflate(R.layout.cafe_list, list, true)
    }
}