<?php

test('basic test', function () {
    $this->assertTrue(true);
});

it('is basic test', function () {
    $this->assertTrue(true);
});

it('is.basic test', function () {
    $this->assertTrue(true);
});

it('is::basic test', function () {
    $this->assertTrue(true);
});

it('is basic.test 2', function () {
    $this->assertTrue(true);
});