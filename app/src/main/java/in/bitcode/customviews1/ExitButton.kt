package `in`.bitcode.customviews1

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.Button

@SuppressLint("AppCompatCustomView")
class ExitButton(
    context: Context,
    attributeSet: AttributeSet?
) : Button(context, attributeSet) {

    var exitable = true

    init {
        this.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )
        this.text = "Exit Application"

        this.setOnClickListener {
            if(!exitable) {
                return@setOnClickListener
            }

            AlertDialog.Builder(context)
                .setTitle("Are you sure? you want to exit!")
                .setPositiveButton(
                    "Yes",
                    object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            System.exit(0)
                        }
                    }
                )
                .setNegativeButton("No") { dialog, which ->
                    dialog.dismiss()
                }
                .create()
                .show()
        }
    }

    constructor(context: Context) : this(context, null)
}