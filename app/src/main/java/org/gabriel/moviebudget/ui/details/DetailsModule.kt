package org.gabriel.moviebudget.ui.details

import toothpick.config.Module

class DetailsModule(view: DetailsContract.View) : Module() {
    init {
        bind(DetailsContract.View::class.java).toInstance(view)
        bind(DetailsContract.Presenter::class.java).to(DetailsPresenter::class.java).singletonInScope()
    }
}