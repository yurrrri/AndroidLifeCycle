package ddwucom.mobile.lifecycle_app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var pref : SharedPreferences = getSharedPreferences("SaveState", 0)
        var userName:String? = pref.getString("username", null)

//       userName이 null이 아닐때, 즉 닉네임을 설정한 상태일때 MainActivity로
        if (userName !=null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//           스택에서 제거 => MainActivity에서 뒤로가기 눌렀을때 splash가 나오는걸 막기 위함
            this.finish()
        }
//       초기 화면일때는 닉네임 화면으로 넘어가게함
        else{
            val intent = Intent(this, InsertUserNameActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }
}