
## Caso de uso:

![caso de uso](.\imagenes\cuentas_bancarias-caso_de_uso.png)

Nota: Para simplificar el ejercicio, cada cuenta tendrá un solo cliente titular. Aunque un mismo cliente podrá ser titular de varias cuentas.

# Tarjetas de requisitos/funcionalidades:

Aquí van algunas fichas con casos de uso a implementar y tareas a realizar. Las podemos recortar y poner en el tablón de gestión del proyecto si es que llevamos alguno. (nota: No están en orden, cada cual tendrá que reorganizarlas según las prioridades que estime oportuno.)

nota: Es importante abordar una ficha cada vez; y no pasar a otra ficha hasta la ficha en curso esté totalmente terminada del todo, completamente. ("done, done")



----

Como cliente, necesito ingresar dinero.
\newline \newline
La forma de validar sera:
\begin{itemize}
\item consulto saldo.                                
\item ingreso dinero.
\item vuelvo a consultar saldo y compruebo que el ingreso se ha realizado correctamente.
\end{itemize}

----

Como cliente, necesito consultar saldo. 
\newline \newline                     
La forma de validar sera:
\begin{itemize}
\item pido consulta de saldo.
\item obtengo los últimos 8 movimientos de la cuenta y el saldo actual en ella.
\end{itemize}

----

Como cliente, necesito sacar dinero. 
\newline \newline
La forma de validar sera:
\begin{itemize}
\item consulto saldo.
\item saco dinero.
\item vuelvo a consultar saldo y compruebo que el reintegro se ha registrado correctamente.
\end{itemize}                        

----                        
                
Como cajero, necesito identificar al cliente y verificar el numero de cuenta. 
\newline \newline
La forma de validar sera:
\begin{itemize}
\item introduzco el número de cuenta y consulto los datos del cliente titular de la misma.
\item compruebo esos datos con respecto al DNI del cliente.
\end{itemize}
Puede darse el caso de que el cliente no me de el número de cuenta. En ese caso:
\begin{itemize}
\item introduzco el DNI del cliente y consulto las cuentas de las que es titular (numero y saldo).
\item el cliente me indica en cual de las cuentas desea operar.
\end{itemize}

----
                        
Como cajero, necesito atender a las operaciones que el cliente solicite.
\newline \newline
La forma de validar sera:
\begin{itemize}
\item puedo realizar un ingreso de dinero en una cuenta.
\item puedo realizar una retirada de dinero en una cuenta.
\item puedo consultar los últimos movimientos y el saldo.
\end{itemize}

----                        
                
Como dueño del banco, necesito tener un registro seguro de todas las transacciones realizadas.
\newline \newline
 La forma de validar sera:                
\begin{itemize}
\item realizar cada una de las operaciones posibles en el sistema: consultar, crear, modificar, etc.
\item consultar el registro para ver que todas y cada una de las operaciones se han registrado correctamente: fecha, hora, tipo de operación, datos afectados por la operación (nota: en las modificaciones, incluir tanto los datos ``antes'' como los datos ``después'').
\end{itemize}
                        
----
                

\end{longtable}

