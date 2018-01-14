package org.gabriel.moviebudget.ui

interface BaseView<T : BasePresenter> {

    var presenter: T

}