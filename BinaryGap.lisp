(defun binary-gap (n) (binary-gap-r (int->bin n) 0 0))

(defun binary-gap-r (bits acc max)
    (cond
        ((eq NIL bits) max)
        ((eq 0 (car (cdr bits))) (binary-gap-r (cdr bits) (+ acc 1) max)) ; start (10..) or keep (00..) counting
        ((and (eq 0 (car bits)) (eq 1 (car (cdr bits)))) (binary-gap-r (cdr bits) 0 (max acc max))) ; stop counting
        (t (binary-gap-r (cdr bits) 0 max)) ; continue
    )
)

(defun int->bin(n)
    (cond
        ((= n 1) '(1))
        ((zerop (mod n 2)) (append (int->bin (/ n 2)) '(0)))
        (t (append (int->bin (floor (/ n 2))) '(1)))
    )
)

(format t "5,~a~%" (binary-gap 1041))
(format t "4,~a~%" (binary-gap 529))
(format t "1,~a~%" (binary-gap 20))
(format t "0,~a~%" (binary-gap 15))
(format t "2,~a~%" (binary-gap 51712))
