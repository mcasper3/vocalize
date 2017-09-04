package io.github.mcasper3.vocalize.activity

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.github.mcasper3.vocalize.base.Presenter
import io.github.mcasper3.vocalize.base.View

open class VocalizeActivity<P, V : View> : DaggerAppCompatActivity() where P : Presenter<V>{

    open lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create the ActivityComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
//        mActivityId = savedInstanceState?.getLong(KEY_ACTIVITY_ID) ?: NEXT_ID.getAndIncrement()
//        val configPersistentComponent: ConfigPersistentComponent
//        if (COMPONENTS_MAP.indexOfKey(mActivityId) < 0) {
//            Timber.i("Creating new ConfigPersistentComponent id=%d", mActivityId)
//            configPersistentComponent = DaggerConfigPersistentComponent.builder()
//                    .applicationComponent(VocalizeApplication.get(this).appComponent)
//                    .build()
//            COMPONENTS_MAP.put(mActivityId, configPersistentComponent)
//        } else {
//            Timber.i("Reusing ConfigPersistentComponent id=%d", mActivityId)
//            configPersistentComponent = COMPONENTS_MAP.get(mActivityId)
//        }
//        activityComponent = configPersistentComponent.activityComponent(ActivityModule(this))
    }

    override fun onResume() {
        super.onResume()
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onPause() {
        presenter.detatch()
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState.putLong(KEY_ACTIVITY_ID, mActivityId)
    }

    override fun onDestroy() {
//        if (!isChangingConfigurations) {
//            Timber.i("Clearing ConfigPersistentComponent id=%d", mActivityId)
//            COMPONENTS_MAP.remove(mActivityId)
//        }

        super.onDestroy()
    }
}