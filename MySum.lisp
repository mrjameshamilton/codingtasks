;; given a list, sum all numbers divisible by 3 or 5

(defun mysum (list) ; simple version
        (apply '+ (remove-if-not (lambda (x) (or (= 0 (mod x 3)) (= 0 (mod x 5)))) list))
)

(defun mysum_r (list) ; recursive version
        (cond
                ((= 0 (list-length list)) 0)
                ((or (= 0 (mod (car list) 3)) (= 0 (mod (car list) 5))) (+ (car list) (mysum (cdr list))))
                (t (mysum_r (cdr list)))
        )
)

;; returns a list of numbers from [a, b)

(defun range (a b) (loop for i from a below b collect i))

;; main
(format t "~a~%~a" (mysum (range 0 10)) (mysum_r (range 0 10)))