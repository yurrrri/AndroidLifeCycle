package ddwucom.mobile.lifecycle_app

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_insert_user_name.*
import kotlinx.android.synthetic.main.activity_modify_user_name.*

class ModifyUserName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modify_user_name)

        var pref : SharedPreferences = getSharedPreferences("SaveState", 0)
        var userName:String? = pref.getString("username", "닉네임")
        edtModifyUserName.setText(userName)

        btnModifyUserName.setOnClickListener(View.OnClickListener {
//           이름 수정
            val edit = pref.edit()
            edit.putString("username", edtModifyUserName.text.toString())
            edit.commit()

            finish()
        })

        btnCancelModifyName.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
}