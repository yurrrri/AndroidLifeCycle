package ddwucom.mobile.lifecycle_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_insert_user_name.*

class InsertUserNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert_user_name)

        btnRegisterUserName.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
//           닉네임을 등록했다면 스택에서 제거
            this.finish()
        })
    }

//  영구적인 데이터는 onPause에 저장해야함
//  onPause가 무슨일이있어도(에러 발생, 뒤로가기 버튼 등 예기치 않은 경우) 데이터를 저장할 수 있는 맨 마지막 메소드라고 할 수 있음.
    override fun onPause() {
        super.onPause()

        val pref = getSharedPreferences("SaveState", 0)
        val edit = pref.edit()

        edit.putString("username", edtUserName.text.toString())
        edit.commit()
    }

//    화면이 처음 생길때 메소드
    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "환영합니다 !", Toast.LENGTH_SHORT).show()
    }
}