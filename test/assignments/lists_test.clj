(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

;(deftest lists
;  (testing "map"
;    (testing "identity with single coll"
;      (is (= [1 2 3] (map' identity [1 2 3]))))))

(deftest filter-test
  (testing "even? predicate"
    (is (= [2 4 6] (filter' even? [1 2 3 4 5 6 9])))))

(deftest reduce-test
  (testing "arity 2"
    (is (= 15 (reduce' + [1 2 3 4 5]))))
  (testing "arity 3"
    (is (= 15 (reduce' + 1 [2 3 4 5])))))
