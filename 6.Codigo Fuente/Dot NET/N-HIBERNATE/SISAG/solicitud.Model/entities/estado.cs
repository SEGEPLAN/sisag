using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace solicitud.Model
{
    public class estado
    {
        private string _ID;
        private string _NOMBRE;
        private IList<solicitud_capacitacion> _SOLICITUD_CAPACITACION = new List<solicitud_capacitacion>();

        public estado()
        {
            throw new System.NotImplementedException();
        }

        public estado(string pID, string pNombre)
        {
            throw new System.NotImplementedException();
        }

        public string ID
        {
            get { return _ID; }
            set { _ID = value; }
        }

        public string NOMBRE
        {
            get { return _NOMBRE; }
            set { _NOMBRE = value; }
        }

        public IList<solicitud_capacitacion> SOLICITUD_CAPACITACION
        {
            get { return _SOLICITUD_CAPACITACION; }
            set { _SOLICITUD_CAPACITACION = value; }
        }

        public void Actualizar()
        {
            throw new System.NotImplementedException();
        }

        public bool Eliminar(string pID)
        {
            throw new System.NotImplementedException();
        }

        public bool Persistencia()
        {
            throw new System.NotImplementedException();
        }

        public estado recuperarObjeto()
        {
            throw new System.NotImplementedException();
        }

        public void recuperarObjetos()
        {
            throw new System.NotImplementedException();
        }
    }
}
