package `in`.bitcode.customviews1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup.LayoutParams
import android.widget.Button
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.CompoundButton.OnCheckedChangeListener

class MainActivity : AppCompatActivity() {

    private lateinit var exitButton: ExitButton
    private lateinit var chkExit: CheckBox
    private lateinit var btnStopSlider: Button

    private lateinit var imageSlider: ImageSlider
    private val imageIds = arrayOf(
        R.drawable.icon_audio_file,
        R.drawable.icon_doc_file,
        R.drawable.icon_mp3_file,
        R.drawable.icon_ppt_file,
        R.drawable.icon_xml_file
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*exitButton = ExitButton(this)
        setContentView(exitButton)*/

        setContentView(R.layout.activity_main)
        chkExit = findViewById(R.id.chkExitable)
        exitButton = findViewById(R.id.exitButton)
        imageSlider = findViewById(R.id.imageSlider)
        btnStopSlider = findViewById(R.id.btnStopSlider)

        imageSlider.delay = 2000L
        imageSlider.imageIds = imageIds

        /*chkExit.setOnCheckedChangeListener(
            object : OnCheckedChangeListener {
                override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                    exitButton.exitable = isChecked
                }
            }
        )*/

        btnStopSlider.setOnClickListener {
            imageSlider.keepRunning = false
        }

        chkExit.setOnCheckedChangeListener { buttonView, isChecked ->
            exitButton.exitable = isChecked
        }
    }
}