package io.github.mcasper3.vocalize.activity

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity

open class VocalizeActivity : DaggerAppCompatActivity() {
//    private val KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID"
//    private val NEXT_ID = AtomicLong(0)
//    private val COMPONENTS_MAP = LongSparseArray<ConfigPersistentComponent>()

//    protected lateinit var activityComponent: ActivityComponent
//    private var mActivityId: Long = 0
//    private var mToggle: ActionBarDrawerToggle? = null
//    private var mDrawer: DrawerLayout? = null
//    private var mNavigationView: NavigationView? = null

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