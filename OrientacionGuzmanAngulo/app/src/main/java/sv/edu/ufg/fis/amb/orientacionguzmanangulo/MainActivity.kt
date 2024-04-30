package sv.edu.ufg.fis.amb.orientacionguzmanangulo

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import sv.edu.ufg.fis.amb.orientacionguzmanangulo.fragments.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        updateFragments()
    }

    private fun updateFragments() {
        val orientation = resources.configuration.orientation

        val transaction = supportFragmentManager.beginTransaction()

        when (orientation) {
            Configuration.ORIENTATION_PORTRAIT -> {
                transaction.replace(R.id.fragment_container, VerticalFragment1())
                transaction.add(R.id.fragment_container, VerticalFragment2())
                transaction.add(R.id.fragment_container, VerticalFragment3())
            }
            Configuration.ORIENTATION_LANDSCAPE -> {
                transaction.replace(R.id.fragment_container, HorizontalFragment1())
                transaction.add(R.id.fragment_container, HorizontalFragment2())
                transaction.add(R.id.fragment_container, HorizontalFragment3())
            }
        }

        transaction.commit()
    }
}
