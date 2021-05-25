package ddwucom.mobile.lifecycle_app

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat.finishAffinity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import kotlinx.android.synthetic.main.activity_insert_user_name.*
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//  앱의 기본 설정 초기화 예를들면 변수나 화면설정, 액티비티의 기능
//  화면전환이나 액티비티가 onStop() 상태에 오래 지속되었을 경우 다시 돌아왔을때 유지되어야 하는 정보
//  앱이 실행되는 내내 유지되어야 하는 정보
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pref : SharedPreferences = getSharedPreferences("SaveState", 0)
        tvUserName.setText(pref.getString("username", "닉네임"))

        btnRestaurantList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("category", "맛집")
            startActivity(intent)
        })

        btnCafeList.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("category", "카페")
            startActivity(intent)
        })

        bottomNavi.run {
            setOnNavigationItemSelectedListener {
                val intent = Intent(this@MainActivity, ModifyUserName::class.java)

                when (it.itemId) {
                    R.id.modifyname -> {
                        startActivity(intent)
                    }
                    R.id.exit -> {
                        finish()
                    }
                }
                true
            }

        }
    }

//   닉네임 변경후 돌아왔을 때 화면 갱신하기위함
//   onStart에서 하지않은 이유는, onPause 상태에서 액티비티로 다시 돌아왔을때 여기서부터 실행되니까 onStart에서하면 화면 갱신이 안될수도 있음.
    override fun onResume() {
        super.onResume()
        var pref : SharedPreferences = getSharedPreferences("SaveState", 0)
        tvUserName.setText(pref.getString("username", "닉네임"))
    }

//    액티비티가 완전히 종료되었을때
    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "다음에 또 만나요!", Toast.LENGTH_SHORT).show()
    }
}