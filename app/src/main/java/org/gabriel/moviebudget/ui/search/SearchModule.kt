package org.gabriel.moviebudget.ui.search

import toothpick.config.Module

class SearchModule(view: SearchContract.View) : Module() {
    init {
        bind(SearchContract.View::class.java).toInstance(view)
        bind(SearchContract.Presenter::class.java).to(SearchPresenter::class.java).singletonInScope()
    }
}