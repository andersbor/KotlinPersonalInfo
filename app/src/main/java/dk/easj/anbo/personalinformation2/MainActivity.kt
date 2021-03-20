package dk.easj.anbo.personalinformation2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

const val REQUEST_CODE_PERSONAL_INFO = 14593

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainInfoButton.setOnClickListener {
            val intent = Intent(this, PersonalInfoActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE_PERSONAL_INFO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_CANCELED) {
            mainMessageTextView.text = "Cancelled"
            Log.d("MINE", "You cancelled")
        } else {
            val name = data?.getStringExtra(NAME)
            val age = data?.getIntExtra(AGE, 0)
            mainMessageTextView.text = ("Name: $name Age: $age")
            Log.d("MINE", "Name " + name)
        }
    }
}
