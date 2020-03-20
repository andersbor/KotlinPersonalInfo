package dk.easj.anbo.personalinformation2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_personal_info.*

const val NAME = "name"
const val AGE = "age"

class PersonalInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        personalCancelButton.setOnClickListener {
            val result = Intent()
            setResult(Activity.RESULT_CANCELED, result)
            finish()
        }

        personalSendButton.setOnClickListener {
            val result = Intent()
            result.putExtra(NAME, personalInfoNameEditText.text.toString())
            try {
                result.putExtra(AGE, personalInfoAgeEditText.text.toString().toInt())
                setResult(Activity.RESULT_OK, result)
                finish()
            } catch (ex: NumberFormatException) {
                personalInfoAgeEditText.error = "Not a number"
            }
        }

        personalInfoNameEditText.setOnLongClickListener {
            Log.d("MINE", "Long click")
            true
        }
    }
}
