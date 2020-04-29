package com.github.odaridavid.designpatterns

import android.os.Bundle
import android.view.View
import com.github.odaridavid.designpatterns.abstractfactory.AbstractFactoryActivity
import com.github.odaridavid.designpatterns.adapter.AdapterActivity
import com.github.odaridavid.designpatterns.base.BaseActivity
import com.github.odaridavid.designpatterns.bridge.BridgeActivity
import com.github.odaridavid.designpatterns.builder.BuilderActivity
import com.github.odaridavid.designpatterns.composite.CompositeActivity
import com.github.odaridavid.designpatterns.decorator.DecoratorActivity
import com.github.odaridavid.designpatterns.factory.FactoryActivity
import com.github.odaridavid.designpatterns.prototype.PrototypeActivity
import com.github.odaridavid.designpatterns.singleton.SingletonActivity

class MainActivity : BaseActivity(), MainNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun navigateToAbstractFactoryActivity(view: View) =
        navigateTo<AbstractFactoryActivity>()

    override fun navigateToFactoryActivity(view: View) = navigateTo<FactoryActivity>()

    override fun navigateToBuilderActivity(view: View) = navigateTo<BuilderActivity>()

    override fun navigateToPrototypeActivity(view: View) = navigateTo<PrototypeActivity>()

    override fun navigateToSingletonActivity(view: View) = navigateTo<SingletonActivity>()

    override fun navigateToAdapterActivity(view: View) = navigateTo<AdapterActivity>()

    override fun navigateToBridgeActivity(view: View) = navigateTo<BridgeActivity>()

    override fun navigateToCompositeActivity(view: View) = navigateTo<CompositeActivity>()

    override fun navigateToDecoratorActivity(view: View) = navigateTo<DecoratorActivity>()

}
