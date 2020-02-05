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

(deftest count-test
  (testing "sequence length"
    (is (= 5 (count' [1 2 3 4 5]))))
  (testing "nil"
    (is (= 0 (count' nil))))
  (testing "[]"
    (is (= 0 (count' []))))
  (testing "map"
    (is (= 2 (count' {:one 1 :two 2}))))
  (testing "string"
    (is (= 6 (count' "abcdef")))))

(deftest reverse-test
  (testing "seqable collection"
    (is (= [5 4 3 2 1] (reverse' [1 2 3 4 5]))))
  (testing "non-seqable collection"
    (is (nil? (reverse' 1)))))

(deftest every-test
  (testing "true condition"
    (is (true? (every?' even? [2 4 6 8]))))
  (testing "false condition"
    (is (false? (every?' even? [2 4 9 6 8])))))

(deftest some-test
  (testing "true condition"
    (is (true? (some?' even? [1 5 3 4]))))
  (testing "false condition"
    (is (false? (some?' even? [1 5 7 9])))))

(deftest ascending-test
  (testing "true condition"
    (is (true? (ascending? [1 2 3 4 5 6]))))
  (testing "false condition"
    (is (false? (ascending? [1 2 3 2 1 0])))))

(deftest sum-of-adjacent-digits-test
  (testing "non-empty collection"
    (is (= [3 5 7] (sum-of-adjacent-digits [1 2 3 4])))))

(deftest difference-test
  (testing "non-empty collection"
    (is (= [5 6 7 8] (difference [1 2 3 4] [5 6 1 2 7 8])))))

(deftest transpose-test
  (testing "non-empty collection"
    (is (= [[\a \d] [\b \e] [\c \f]] (transpose [[\a \b \c] [\d \e \f]])))))

(deftest max-three-digit-sequence-test
  (testing "with less than three numbers"
    (is (= [1 2] (max-three-digit-sequence [1 2]))))
  (testing "with more than three numbers"
    (is (= [2 -1 2] (max-three-digit-sequence [1 2 -1 2 0])))))

(deftest union-test
  (testing "with no common elements"
    (is (= [1 2 3 4 5 6] (union [1 2 3] [ 4 5 6]))))
  (testing "with common elements but elements doesn't repeat"
    (is (= [1 2 3 4 5] (union [1 2 3] [3 4 5]))))
  (testing "with common element and elements repeat"
    (is (= [1 2 3 1 4 5 6 4] (union [1 2 3 1] [4 5 6 3 2 4])))))