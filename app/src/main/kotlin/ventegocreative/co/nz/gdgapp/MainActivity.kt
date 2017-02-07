package ventegocreative.co.nz.gdgapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife

import ventegocreative.co.nz.gdgapp.adapters.AnimalListAdapter

import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import ventegocreative.co.nz.gdgapp.commands.PetFindCommand
import ventegocreative.co.nz.gdgapp.model.domain.Pet

class MainActivity : AppCompatActivity() {

    @BindView(R.id.animal_list)
    lateinit var animalList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MainActivityUI().setContentView(this)

        ButterKnife.bind(this)

        doAsync(exceptionHandler = { throwable : Throwable -> throwable.printStackTrace() }) {
            val result = PetFindCommand("90210","cat").execute()
            uiThread {
                animalList.adapter = AnimalListAdapter(result,
                    object: AnimalListAdapter.ItemClickListener{
                        override fun invoke(pet: Pet) {
                            toast(pet.name)
                        }
                    }
                )

            }
        }

    }
}

class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        frameLayout {
            recyclerView {
                id = R.id.animal_list
                layoutManager = LinearLayoutManager(ctx)
            }
        }
    }
}
