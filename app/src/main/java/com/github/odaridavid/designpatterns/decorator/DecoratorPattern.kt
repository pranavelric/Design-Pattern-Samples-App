/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.github.odaridavid.designpatterns.decorator


interface Bar {
    fun open()
    fun close()
    fun executeHappyHour()
    fun setup()
}

class CollegeBar : Bar {
    override fun setup() {
        println("College Bar Setup")
    }

    override fun open() {
        println("College Bar open")
    }

    override fun close() {
        println("College Bar closed")
    }

    override fun executeHappyHour() {
        println("College Bar Happy Hour")
    }
}

class SportsBar : Bar {
    override fun setup() {
        println("Sports Bar Setup")
    }

    override fun open() {
        println("Sports Bar open")
    }

    override fun close() {
        println("Sports Bar closed")
    }

    override fun executeHappyHour() {
        println("Sports Bar Happy Hour")
    }
}

abstract class BarDecorator(bar: Bar) : Bar by bar

class HalloweenBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Halloween Ornaments")
    }
}

class ChristmasBarDecorator(bar: Bar) : BarDecorator(bar) {
    override fun setup() {
        super.setup()
        println("Adding Christmas Ornaments")
    }
}